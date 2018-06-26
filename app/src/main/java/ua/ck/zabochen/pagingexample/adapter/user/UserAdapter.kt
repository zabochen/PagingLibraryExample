package ua.ck.zabochen.pagingexample.adapter.user

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import ua.ck.zabochen.pagingexample.R
import ua.ck.zabochen.pagingexample.model.db.User

class UserAdapter(userDiffUtil: DiffUtil.ItemCallback<User>) : PagedListAdapter<User, UserAdapter.UserViewHolder>(userDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // ItemView
        val view: View = LayoutInflater.from(parent.context)
                .inflate(
                        R.layout.adapter_item_user,
                        parent,
                        false
                )

        // ViewHolder
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            ButterKnife.bind(this, itemView)
        }

        @BindView(R.id.adapterItemUser_textView_userId)
        lateinit var mUserId: TextView

        @BindView(R.id.adapterItemUser_textView_userName)
        lateinit var mUserName: TextView

        fun bind(user: User?) {
            mUserId.text = user?.id.toString()
            mUserName.text = user?.name
        }
    }

}