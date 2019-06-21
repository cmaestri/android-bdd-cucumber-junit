package com.cmaestri.androidbddcucumberjunit.acceptance.stepdefinitions.belly

import cucumber.api.Scenario
import cucumber.api.java8.En
import io.cucumber.datatable.DataTable
import org.junit.Assert

var lastInstance: BellyStepDefs? = null

class BellyStepDefs : En {

    init {
        Before { _: Scenario ->
            Assert.assertNotSame(this,
                lastInstance
            )
            lastInstance = this
        }

        BeforeStep { _: Scenario ->
            Assert.assertSame(this, lastInstance)
            lastInstance = this
        }

        AfterStep { _: Scenario ->
            Assert.assertSame(this, lastInstance)
            lastInstance = this
        }

        After { _: Scenario ->
            Assert.assertSame(this, lastInstance)
            lastInstance = this
        }

        Given("this data table:") { peopleTable: DataTable ->
            val people: List<Person> = peopleTable.asList(
                Person::class.java)
            Assert.assertEquals("Aslak", people[0].first)
            Assert.assertEquals("Hellesoy", people[0].last)
        }

        val alreadyHadThisManyCukes = 1
        Given("I have {int} cukes in my belly") { i: Int ->
            Assert.assertEquals(1, alreadyHadThisManyCukes)
            Assert.assertEquals(42, i)
        }

        val localState = "hello"
        Then("I really have {int} cukes in my belly") { i: Int ->
            Assert.assertEquals(42, i)
            Assert.assertEquals("hello", localState)
        }

        Given("A statement with a body expression$") { Assert.assertTrue(true) }

        Given("A statement with a simple match$") { Assert.assertTrue(true) }

        val localInt = 1
        Given("A statement with a scoped argument$") { Assert.assertEquals(2, localInt + 1) }

        Given("I will give you {int} and {float} and {string} and {word}") { a: Int, b: Float, c:String, d:String ->
            Assert.assertEquals(1, a)
            Assert.assertEquals(2.2f, b)
            Assert.assertEquals("three and four", c)
            Assert.assertEquals("five", d)
        }
        Given("I will give you {int}") { i:Int ->
            Assert.assertEquals(1, i)
        }
    }
}

data class Person(val first: String?, val last: String?)