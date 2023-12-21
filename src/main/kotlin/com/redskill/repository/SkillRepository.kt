package com.redskill.repository

import com.redskill.model.Skill

interface SkillRepository {
    fun createOne(skillToCreate: Skill)
    fun getAll(): List<Skill>
    fun getOne(index: String): Skill
}