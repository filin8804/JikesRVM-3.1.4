/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 *
 * (C) Copyright IBM Corp. 2001, 2003
 */
package org.mmtk.vm;

import org.mmtk.plan.TraceLocal;
import org.mmtk.utility.scan.*;
import org.mmtk.utility.Constants;

import org.vmmagic.unboxed.*;

/**
 * $Id$ 
 *
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @author Perry Cheng
 *
 * @version $Revision$
 * @date $Date$
 */
public class Scanning implements Constants {
  /**
   * Delegated scanning of a object, processing each pointer field
   * encountered. 
   *
   * @param object The object to be scanned.
   */
  public static void scanObject(TraceLocal trace, ObjectReference object) {}

  /**
   * Delegated precopying of a object's children, processing each pointer field
   * encountered. 
   *
   * @param trace The trace object to use for precopying.
   * @param object The object to be scanned.
   */
  public static void precopyChildren(TraceLocal trace, ObjectReference object) {}

  /**
   * Delegated enumeration of the pointers in an object, calling back
   * to a given plan for each pointer encountered. 
   *
   * @param object The object to be scanned.
   * @param e the Enumerator object through which the callback
   * is made
   */
  public static void enumeratePointers(ObjectReference object, Enumerator e) {}

  /**
   * Prepares for using the <code>computeAllRoots</code> method.  The
   * thread counter allows multiple GC threads to co-operatively
   * iterate through the thread data structure (if load balancing
   * parallel GC threads were not important, the thread counter could
   * simply be replaced by a for loop).
   */
  public static void resetThreadCounter() {}

  /**
   * Pre-copy all potentially movable instances used in the course of
   * GC.  This includes the thread objects representing the GC threads
   * themselves.  It is crucial that these instances are forwarded
   * <i>prior</i> to the GC proper.  Since these instances <i>are
   * not</i> enqueued for scanning, it is important that when roots
   * are computed the same instances are explicitly scanned and
   * included in the set of roots.  The existence of this method
   * allows the actions of calculating roots and forwarding GC
   * instances to be decoupled. 
   */
  public static void preCopyGCInstances(TraceLocal trace) {}
 
 /**
   * Computes all roots.  This method establishes all roots for
   * collection and places them in the root values, root locations and
   * interior root locations queues.  This method should not have side
   * effects (such as copying or forwarding of objects).  There are a
   * number of important preconditions:
   *
   * <ul> 
   * <li> All objects used in the course of GC (such as the GC thread
   * objects) need to be "pre-copied" prior to calling this method.
   * <li> The <code>threadCounter</code> must be reset so that load
   * balancing parallel GC can share the work of scanning threads.
   * </ul>
   *
   * @param The trace to use for computing roots.
   */
  public static void computeAllRoots(TraceLocal trace) {}

}