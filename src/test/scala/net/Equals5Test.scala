package net

import org.scalatest.Matchers

import org.scalatest._
import org.scalatest.prop.Checkers._

class Equals5Test extends FlatSpec with Matchers {

	"Trying to create an `Equals5` case class with an invalid Int" should "fail to compile" in {
		"Equals5(-555)" shouldNot compile
	}
}