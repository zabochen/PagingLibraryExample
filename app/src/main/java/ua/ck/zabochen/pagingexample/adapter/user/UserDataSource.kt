package ua.ck.zabochen.pagingexample.adapter.user

import android.arch.paging.PositionalDataSource
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import ua.ck.zabochen.pagingexample.helper.DatabaseHelper
import ua.ck.zabochen.pagingexample.model.db.User

class UserDataSource(databaseHelper: DatabaseHelper) : PositionalDataSource<User>(),
        AnkoLogger {

    private val mDatabaseHelper = databaseHelper

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<User>) {

        info { "loadInitial: START_POSITION => ${params.requestedStartPosition}, LOAD_SIZE => ${params.requestedLoadSize}" }

        val userList: List<User> = mDatabaseHelper.getUserList(
                params.requestedStartPosition,
                params.requestedLoadSize)

        // callback.onResult(userList, 0)
        callback.onResult(userList, params.requestedStartPosition)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<User>) {

        info { "loadRange: START_POSITION => ${params.startPosition}, LOAD_SIZE => ${params.loadSize}" }

        val userList: List<User> = mDatabaseHelper.getUserList(
                params.startPosition,
                params.loadSize)
        callback.onResult(userList)
    }

}