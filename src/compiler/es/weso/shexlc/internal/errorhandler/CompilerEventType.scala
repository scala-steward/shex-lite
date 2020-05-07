//------------------------------------------------------------------------------
// File: CompilerEventType.scala
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

package es.weso.shexlc.internal.errorhandler

/**
  * To standardize the different types of events that can occur in the compiler, this contract is created so that all of
  * them start from this same source.
  *
  * @author Guillermo Facundo Colunga
  */
trait CompilerEventType {

  /**
    * Gets the code of the compiler event type, the code should be unique.
    *
    * @return the code of the compiler event type.
    */
  def getCode: String

  /**
    * Gets the description of the event.
    *
    * @return the description of the event.
    */
  def getDescription: String
}
