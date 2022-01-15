package com.claudiogalvaodev.concatadaptertraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.claudiogalvaodev.concatadaptertraining.AnnouncementsAdapter.*
import com.claudiogalvaodev.concatadaptertraining.databinding.ItemAnnouncementBinding

class AnnouncementsAdapter: ListAdapter<Announcement, AnnouncementsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementsViewHolder {
        return AnnouncementsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AnnouncementsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Announcement>() {
            override fun areItemsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
                return oldItem.image == newItem.image
            }

            override fun areContentsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
                return oldItem == newItem
            }

        }
    }

    class AnnouncementsViewHolder(private val binding: ItemAnnouncementBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(announcement: Announcement) {
            binding.itemAnnouncementImage.setImageResource(announcement.image)
        }

        companion object {
            fun create(parent: ViewGroup): AnnouncementsViewHolder {
                val binding = ItemAnnouncementBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return AnnouncementsViewHolder(binding)
            }
        }
    }
}