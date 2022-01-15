package com.claudiogalvaodev.concatadaptertraining

import androidx.annotation.DrawableRes

data class Announcement(
    @DrawableRes
    val image: Int,
    val order: Int
)

val announcements = listOf(
    Announcement(R.drawable.announcement3, 3),
    Announcement(R.drawable.announcement2, 2),
    Announcement(R.drawable.announcement4, 4),
    Announcement(R.drawable.announcement1, 1),
)