package ua.ck.zabochen.pagingexample.ui.main

import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import org.jetbrains.anko.AnkoLogger
import ua.ck.zabochen.pagingexample.R
import ua.ck.zabochen.pagingexample.adapter.user.MainThreadExecutor
import ua.ck.zabochen.pagingexample.adapter.user.UserAdapter
import ua.ck.zabochen.pagingexample.adapter.user.UserDataSource
import ua.ck.zabochen.pagingexample.adapter.user.UserDiffUtil
import ua.ck.zabochen.pagingexample.helper.DatabaseHelper
import ua.ck.zabochen.pagingexample.model.db.User
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), AnkoLogger {

    @BindView(R.id.activityMain_recyclerView)
    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUi()
        setAdapter()
    }

    private fun setUi() {
        // Layout & ButterKnife
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    private fun setAdapter() {

        // DataSource
        val userDataSource = UserDataSource(DatabaseHelper())

        // PagedList Config
        val pagedListConfig: PagedList.Config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(20)
                .build()

        // PagedList
        val pagedList: PagedList<User> = PagedList.Builder(userDataSource, pagedListConfig)
                .setNotifyExecutor(MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .setInitialKey(50)
                .build()


        // Adapter
        val userAdapter = UserAdapter(UserDiffUtil())
        userAdapter.submitList(pagedList)

        // RecyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = userAdapter

    }

}
