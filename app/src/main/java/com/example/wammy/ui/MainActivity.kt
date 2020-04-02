package com.example.wammy.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import com.dev.adnetworkm.CheckNetworkStatus
import com.example.wammy.R
import com.example.wammy.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val viewModel: TodoViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            // Ordinary Intent for launching a new activity
            // Ordinary Intent for launching a new activity
            val intent = Intent(this, ReadActivity::class.java)

            // Get the transition name from the string
            // Get the transition name from the string
            val transitionName = getString(R.string.transition_string)

            // Define the view that the animation will start from
            // Define the view that the animation will start from
            val viewStart: View = findViewById(R.id.fab)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                viewStart,  // Starting view
                transitionName // The String
            )
            //Start the Intent
            //Start the Intent
            ActivityCompat.startActivity(this, intent, options.toBundle())
        }

        CheckNetworkStatus.getNetworkLiveData(applicationContext).observe(this, Observer { t ->
            when (t) {
                true -> {
                    showFirstTodo()
                }
                false -> {
                    Toast.makeText(this, "No Network Connection", Toast.LENGTH_SHORT).show()
                }
                null -> {
                    // TODO: Handle the connection...
                }
            }
        })


    }

    private fun showFirstTodo() {

        viewModel.firstTodo.observe(this, Observer { t ->
            // val mLayoutManager = LinearLayoutManager(applicationContext)
            // recyclerView.layoutManager = mLayoutManager
            recyclerView.adapter =
                NewsAdapter(t, applicationContext)
            recyclerView.adapter?.notifyDataSetChanged()

        })
    }
}
