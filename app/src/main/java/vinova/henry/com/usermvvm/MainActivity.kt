package vinova.henry.com.usermvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import vinova.henry.com.usermvvm.model.User

class MainActivity : AppCompatActivity() {
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)

        viewModel.users.observe(this, Observer{
            rvMain.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            userAdapter = UserAdapter(this, it)
            rvMain.adapter = userAdapter
            userAdapter.notifyDataSetChanged()

        })
        viewModel.set("")

        svMain.setOnQueryTextListener(object : SearchView.OnQueryTextListener, android.support.v7.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.set(newText.toString())
                return false
            }

        })
    }
}

