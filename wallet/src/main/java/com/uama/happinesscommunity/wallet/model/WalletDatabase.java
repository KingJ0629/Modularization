/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uama.happinesscommunity.wallet.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * The Room database that contains the Users table
 */
@Database(entities = {Wallet.class}, version = 1, exportSchema = false)
public abstract class WalletDatabase extends RoomDatabase {

    private static volatile WalletDatabase INSTANCE;

    public abstract WalletDao userDao();

    public static WalletDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (WalletDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WalletDatabase.class, "wallet.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
