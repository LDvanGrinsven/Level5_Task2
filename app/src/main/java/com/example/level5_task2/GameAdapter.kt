package com.example.level5_task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.level5_task2.database.Game
import kotlinx.android.synthetic.main.game_item.view.*
import java.text.SimpleDateFormat

class GameAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }


    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.game_item,
                parent,
                false
            )
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            val formatter = SimpleDateFormat("dd MMMM yyyy")

            val release =  formatter.format(game.date)
            itemView.tvTitle.setText(game.title)
            itemView.tvRelease.setText(itemView.context.getString(R.string.release) + release)
            itemView.tvPlatform.setText(game.platform)
        }
    }
}