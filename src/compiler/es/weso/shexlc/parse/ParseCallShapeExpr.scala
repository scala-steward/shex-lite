//------------------------------------------------------------------------------
// File: ParseCallShapeExpr.scala
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
//------------------------------------------------------------------------------

package es.weso.shexlc.parse

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr.{CallBaseExpr, CallPrefixExpr, CallShapeExpr, Expression}
import es.weso.shexlc.parse.ast.Position
import es.weso.shexlc.parse.generated.ShexLiteParser
import org.antlr.v4.runtime.misc.Interval

/**
  * The call shape expression parser generates a call shape expression  from
  * the parser context.
  *
  * @author Guillermo Facundo Colunga
  * @param ctx     of the parser.
  * @param visitor to propagate any action.
  */
class ParseCallShapeExpr(
  ctx: ShexLiteParser.Call_shape_exprContext,
  visitor: ASTBuilderParser,
  ccontext: CompilationContext
) extends HasParseResult[CallShapeExpr] {

  override def getParseResult: CallShapeExpr = {
    val sourceName = ccontext.getInputContext.getSourceName
    val line       = ctx.start.getLine
    val column     = ctx.start.getCharPositionInLine
    val pos        = Position.pos(sourceName, line, column)
    val tokenRange = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val content    = ccontext.getInputContext.getText(tokenRange)

    ctx.base_relative_lbl match {
      case null => {
        val prefix     = if (ctx.prefix_lbl == null) "" else ctx.prefix_lbl.getText
        val shape      = ctx.shape_lbl.getText
        val prefixCall = new CallPrefixExpr(pos, tokenRange, content, prefix, shape)

        new CallShapeExpr(pos, tokenRange, content, prefixCall)
      }
      case _ => {
        val shape =
          ctx.base_relative_lbl.accept(visitor).asInstanceOf[Expression].asLiteralIRIValueExpr.value
        val prefixCall = new CallBaseExpr(pos, tokenRange, content, shape)

        new CallShapeExpr(pos, tokenRange, content, prefixCall)
      }
    }
  }
}
