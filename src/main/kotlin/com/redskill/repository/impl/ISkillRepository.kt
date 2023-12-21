package com.redskill.repository.impl

import com.redskill.model.Skill
import com.redskill.repository.SkillRepository

class ISkillRepository: SkillRepository{
    override fun createOne(skillToCreate: Skill) {
        //skills.add(skillToCreate)
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Skill> {
        TODO("Not yet implemented")
    }

    override fun getOne(index: String): Skill {
        TODO("Not yet implemented")
    }
}