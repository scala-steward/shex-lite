/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package compiler.internal.error

/**
 * The error type standardises the different types of errors that the compiler can throw, that way, error types are not
 * free and must be fold to some of the existing error types. An error type is composed of a unique code that identifies
 * atomically the error type and a human friendly description.
 */
trait ErrType {

  /**
   * Unique code that identifies atomically the error type.
   */
  val code: String

  /**
   * Description of the error. Not the cause of the error but the error itself.
   */
  val description: String
}
