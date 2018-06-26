package ua.ck.zabochen.pagingexample.adapter.user

import android.support.v7.util.DiffUtil
import ua.ck.zabochen.pagingexample.model.db.User

class UserDiffUtil : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User?, newItem: User?): Boolean {
        return oldItem?.id == newItem?.id
    }

    override fun areContentsTheSame(oldItem: User?, newItem: User?): Boolean {
        return oldItem?.name == newItem?.name
    }

}