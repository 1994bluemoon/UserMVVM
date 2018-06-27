package vinova.henry.com.usermvvm

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*
import vinova.henry.com.usermvvm.UserAdapter.ViewHolder
import vinova.henry.com.usermvvm.model.User

data class UserAdapter(var context: Context, var users: List<User>?) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (users != null) users!!.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(users?.get(position), this.context)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun setData(user: User?, context: Context){
            itemView.tvEmail.text = user?.email
            itemView.tvUserName.text = user?.username
            Picasso.with(context).load(user?.avatar).into(itemView.imAvatar)
        }
    }

}