package com.z9.jur.jetpackcomposemvvm.domain.util

interface DomainMapper <T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel) : T
}