package ua.ck.zabochen.pagingexample.helper

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import ua.ck.zabochen.pagingexample.model.db.User

class DatabaseHelper : AnkoLogger {

    fun getUserList(from: Int, size: Int): ArrayList<User> {

        info { "From: $from, size: $size" }

        val userList: ArrayList<User> = ArrayList()
        for (i in from..(from + size)) {
            userList.add(User(i, "User_$i"))
        }
        return userList
    }

}