package com.uama.happinesscommunity.net;

/**
 * Created by Jin on 2016/7/1.
 * Description
 */
public class ApiClient {

    public static final String SUCCESS = "100";


    /**********************
     * get service
     ******************************/
//    private static MineService mMineService;
//
//    static MineService getMineService(Context context) {
//        if (null == mMineService) {
//            mMineService = ProtocolManagers.getInstance(context).getService(MineService.class);
//        }
//        return mMineService;
//    }
//
//
//    private static LoginService loginService;
//
//    static LoginService getLoginService(Context context) {
//        if (null == loginService) {
//            loginService = ProtocolManagers.getInstance(context).getService(LoginService.class);
//        }
//        return loginService;
//    }
//
//
//    static LoginService getLoginService(Context context, long shortTime) {
//        return ProtocolManagers.getInstance(context, shortTime).getService(LoginService.class);
//    }
//
//    private static ActiveService mActiveService;
//
//    static ActiveService getActiveService(Context context) {
//        if (null == mActiveService) {
//            mActiveService = ProtocolManagers.getInstance(context).getService(ActiveService.class);
//        }
//        return mActiveService;
//    }
//
//    private static ServiceService mServiceService;
//
//    static ServiceService getServiceService(Context context) {
//        if (null == mServiceService) {
//            mServiceService = ProtocolManagers.getInstance(context).getService(ServiceService.class);
//        }
//        return mServiceService;
//    }
//
//    private static LifeService mLifeService;
//
//    static LifeService getLifeService(Context context) {
//        if (null == mLifeService) {
//            mLifeService = ProtocolManagers.getInstance(context).getService(LifeService.class);
//        }
//        return mLifeService;
//    }
//
//    private static MicroService microService;
//
//    static MicroService getMicroService(Context context) {
//        if (null == microService) {
//            microService = ProtocolManagers.getInstance(context).getService(MicroService.class);
//        }
//        return microService;
//    }
//
//    private static MessageService messageService;
//
//    static MessageService getMessageService(Context context) {
//        if (null == messageService) {
//            messageService = ProtocolManagers.getInstance(context).getService(MessageService.class);
//        }
//        return messageService;
//    }
//
//    public static Call<OnlineShopInfoResp> getOnlineShopInfo(Context context, String subId, int type,
//                                                             Callback<OnlineShopInfoResp> callback) {
//        Call<OnlineShopInfoResp> call = getLifeService(context).getOnlineShopInfo(subId, type);
//        call.enqueue(callback);
//        return call;
//    }
//
//    /**
//     * 获取商家评价列表
//     */
//    public static Call<ShopCommentListResp> getShopCommentList(Context context, Map<String, String> params,
//                                                               Callback<ShopCommentListResp> callback) {
//        Call<ShopCommentListResp> call = getLifeService(context).getShopCommentList(params);
//        call.enqueue(callback);
//        return call;
//    }
}
