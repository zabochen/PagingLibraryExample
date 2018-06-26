package ua.ck.zabochen.pagingexample.adapter.user

import android.arch.paging.PositionalDataSource
import ua.ck.zabochen.pagingexample.helper.DatabaseHelper
import ua.ck.zabochen.pagingexample.model.db.User

class UserDataSource(databaseHelper: DatabaseHelper) : PositionalDataSource<User>() {

    private val mDatabaseHelper = databaseHelper

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<User>) {
        val userList: List<User> = mDatabaseHelper.getUserList(
                params.requestedStartPosition,
                params.requestedLoadSize)
        callback.onResult(userList, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<User>) {
        val userList: List<User> = mDatabaseHelper.getUserList(
                params.startPosition,
                params.loadSize)
        callback.onResult(userList)
    }

}