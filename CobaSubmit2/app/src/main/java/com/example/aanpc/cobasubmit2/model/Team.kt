package com.dicoding.kotlinacademy.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Team(
        @SerializedName("idTeam")
        var teamId: String? = null,

        @SerializedName("strTeam")
        var teamName: String? = null,

        @SerializedName("strTeamBadge")
        var teamBadge: String? = null
)