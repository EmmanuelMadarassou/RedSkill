package com.redskill

import com.apurebase.kgraphql.GraphQL
import com.redskill.database.skills
import com.redskill.model.Skill
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    install(GraphQL) {
        playground = true
        endpoint = "/"
        schema {
            type<Skill>() {
                description = "Skill object"
            }
            inputType<Skill> {
                name = "skillInput"
            }

            query("hello") {
                resolver { -> "World!" }
            }
            query("skills") {
                description = "Returns a list of skill"
                resolver { -> skills }
            }
            query("skill") {
                description = "Returns a skill matched by id or null if id is invalid"
                resolver { id: String -> skills.first{it.id == id } }
            }
            mutation("addSkill") {
                description = "Adds a new skill and return"
                resolver { newSkill: Skill -> skills.add(newSkill) }
            }
        }
    }
}