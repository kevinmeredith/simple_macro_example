package net

import scala.language.experimental.macros
import scala.reflect.macros.Context

case class Equals5(value: Int) {
	require(value == 5)
}

object Equals5 {
	implicit def wrapInt(n: Int): Equals5 = macro verifyIntEquals5

	def verifyIntEquals5(c: Context)(n: c.Expr[Int]): c.Expr[Equals5] = {
    import c.universe._

    val tree = n.tree match {
      case Literal(Constant(x: Int)) if x == 5 =>
        q"_root_.net.Equals5($n)"
      case Literal(Constant(x: Int)) =>
        c.abort(c.enclosingPosition, s"$x != 0")
      case _ => 
        q"_root_.net.Equals5($n)"
    }
    c.Expr(tree)
  }
}