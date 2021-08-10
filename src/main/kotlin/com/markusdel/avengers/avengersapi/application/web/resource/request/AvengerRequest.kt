package com.markusdel.avengers.avengersapi.application.web.resource.request

import com.markusdel.avengers.avengersapi.domain.avenger.Avenger
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AvengerRequest(

        @field:NotBlank
        @field:NotNull
        @field:NotEmpty
        val nick: String,

        @field:NotBlank
        @field:NotNull
        @field:NotEmpty
        val person: String,

        val description: String? = "",
        val history: String? = "",
) {
        fun toAvenger() = Avenger(
                nick = nick,
                person = person,
                description = description,
                history = history
        )

        companion object {
                fun to(id: Long?, request: AvengerRequest) = Avenger(
                        id = id,
                        nick = request.nick,
                        person = request.person,
                        description = request.description,
                        history = request.history
                )
        }
}