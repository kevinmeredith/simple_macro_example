package net

import org.scalatest.Matchers

import org.scalatest._
import org.scalatest.prop.Checkers._

class Equals5Test extends FlatSpec with Matchers {

	it should "throw an IllegalArgumentException when trying to make an invalid `Equals5` directly" in {
		intercept[IllegalArgumentException] {
			Equals5(-555) //
		}
	}

	import Equals5.wrapInt

	it should "not compile when using the macro constructor to build an `Equals5` with a constant" in {
		"""
		import net.Equals5._; wrapInt(-555)
		""".shouldNot(compile)
	}
}