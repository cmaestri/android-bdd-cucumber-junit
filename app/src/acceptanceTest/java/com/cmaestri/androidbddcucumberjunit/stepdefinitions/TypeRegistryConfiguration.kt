package com.cmaestri.androidbddcucumberjunit.stepdefinitions

import com.cmaestri.androidbddcucumberjunit.stepdefinitions.belly.Person
import cucumber.api.TypeRegistry
import cucumber.api.TypeRegistryConfigurer
import io.cucumber.datatable.DataTableType
import io.cucumber.datatable.TableEntryTransformer
import java.util.*

class TypeRegistryConfiguration  : TypeRegistryConfigurer {

    override fun locale(): Locale {
        return Locale.ENGLISH
    }

    override fun configureTypeRegistry(typeRegistry: TypeRegistry) {
        typeRegistry.defineDataTableType(DataTableType(
            Person::class.java,
            TableEntryTransformer<Person> {
                map: Map<String, String> ->
                Person(map["first"], map["last"])
            }
        ))
    }
}