package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNREACHABLE_CODE")
class NotesRVAdapter(private val context: Context, private val listener: INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    val allNote = ArrayList<Note>()
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)
        val shareButton = itemView.findViewById<ImageView>(R.id.shareButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNote[viewHolder.adapterPosition])
        }
        return viewHolder
        viewHolder.shareButton.setOnClickListener{
            listener.onItemClicked(allNote[viewHolder.adapterPosition])
        }

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNote[position]
        holder.textView.text = currentNote.text

    }

    override fun getItemCount(): Int {
        return allNote.size
    }
    fun updateList(newList: List<Note>){
        allNote.clear()
        allNote.addAll(newList)
        notifyDataSetChanged()
    }

}
interface INotesRVAdapter{
    fun onItemClicked(note: Note)
}