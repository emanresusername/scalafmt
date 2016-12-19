package org.scalafmt.config

import metaconfig.ConfigReader
import metaconfig.Reader

/**
  * @param openParenLambda
  *   If true, vertically aligns by the opening parens of lambda. See
  *   file OpenParenLambda.stat.
  *   If false, treats lambda parameter lists like regular definition lists.
  */
@ConfigReader
case class Align(
    openParenCallSite: Boolean = true,
    openParenDefnSite: Boolean = true,
    openParenLambda: Boolean = true,
    mixedOwners: Boolean = false,
    tokens: Set[AlignToken] = Set.empty[AlignToken],
    arrowEnumeratorGenerator: Boolean = false,
    ifWhileOpenParen: Boolean = true
) {
  implicit val alignReader: Reader[Set[AlignToken]] =
    ScalafmtConfig.alignReader(tokens)
}
