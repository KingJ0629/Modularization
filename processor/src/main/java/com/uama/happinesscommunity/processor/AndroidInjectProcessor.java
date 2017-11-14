package com.uama.happinesscommunity.processor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;


/**
 * Created by Jin on 2017/11/3.
 * Description
 */
@AutoService(Processor.class)
public class AndroidInjectProcessor extends AbstractProcessor {
	
	private Types mTypeUtils;
	private Elements mElementUtils;
	private Filer mFiler;
	private Messager mMessager;
	
	public static final String SUFFIX = "$$Component";
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		//初始化我们需要的基础工具
		mTypeUtils = processingEnv.getTypeUtils();
		mElementUtils = processingEnv.getElementUtils();
		mFiler = processingEnv.getFiler();
		mMessager = processingEnv.getMessager();
	}
	
	@Override
	public SourceVersion getSupportedSourceVersion() {
		//支持的java版本
		return SourceVersion.RELEASE_8;
	}
	
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		// Supported annotations
		Set<String> annotations = new LinkedHashSet<>();
		annotations.add(ActivityInject.class.getCanonicalName());
		annotations.add(FragmentInject.class.getCanonicalName());
		return annotations;
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
		
		info("AndroidInjectProcessor");

		// 遍历所有被注解了@ActivityInject的元素
		for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(ActivityInject.class)) {

			System.out.println(annotatedElement.getSimpleName());

			// 检查被注解为@ActivityInject的元素是否是一个类
			if (annotatedElement.getKind() != ElementKind.CLASS) {
				error(annotatedElement, "Only classes can be annotated with @%s", ActivityInject.class.getSimpleName());
				return true; // 退出处理
			}

			// 注解本身，可以获取注解的参数
			ActivityInject annotation = annotatedElement.getAnnotation(ActivityInject.class);
			//解析，并生成代码
			analyze(annotatedElement);
		}

		// 遍历所有被注解了@FragmentInject的元素
		for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(FragmentInject.class)) {

			System.out.println(annotatedElement.getSimpleName());

			// 检查被注解为@ActivityInject的元素是否是一个类
			if (annotatedElement.getKind() != ElementKind.CLASS) {
				error(annotatedElement, "Only classes can be annotated with @%s", FragmentInject.class.getSimpleName());
				return true; // 退出处理
			}
			
			//解析，并生成代码
			analyze(annotatedElement);
		}

		return true;
	}
	
	private void analyze(Element element) {
		ClassName activityName = ClassName.get(getPackageName((TypeElement) element), element.getSimpleName().toString());
		ClassName javaPoetComponent = ClassName.get("dagger", "Component");
		
		MethodSpec inject = MethodSpec.methodBuilder("inject")
				.returns(void.class)
				.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
				.addParameter(activityName, "activity")
				.build();
		
		TypeSpec component = TypeSpec.interfaceBuilder(element.getSimpleName().toString() + SUFFIX)
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(javaPoetComponent)
				.addMethod(inject)
				.build();
		
		JavaFile javaFile = JavaFile.builder(getPackageName((TypeElement) element), component)
				.build();
		
		try {
			javaFile.writeTo(processingEnv.getFiler());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getPackageName(TypeElement type) {
		return mElementUtils.getPackageOf(type).getQualifiedName().toString();
	}
	
	private void error(Element e, String msg, Object... args) {
		mMessager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
	}
	
	private void info(String msg, Object... args) {
		mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(msg, args));
	}
	
}
