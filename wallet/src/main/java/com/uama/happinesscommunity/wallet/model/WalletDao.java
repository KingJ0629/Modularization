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

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Data Access Object for the wallets table.
 */
@Dao
public interface WalletDao {

    @Query("SELECT * FROM wallets LIMIT 10")
    List<Wallet> getUser();

    /**
     * Insert a wallet in the database. If the wallet already exists, replace it.
     * @param wallet the wallet to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(Wallet wallet);

    /**
     * Delete all wallets.
     */
    @Query("DELETE FROM wallets")
    void deleteAllWallets();
}
