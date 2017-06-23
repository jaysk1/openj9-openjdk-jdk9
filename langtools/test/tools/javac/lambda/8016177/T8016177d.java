/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 8016081 8016178
 * @summary structural most specific and stuckness
 * @compile T8016177d.java
 */
import java.util.*;

class T8016177d {

    interface UnaryOperator<X> {
      X m(X x);
    }

    interface IntStream {
       IntStream sorted();
       IntStream distinct();
       IntStream limit(int i);
    }

    abstract class WrappingUnaryOperator<S> implements UnaryOperator<S>  { }

    <S1> WrappingUnaryOperator<S1> wrap1(UnaryOperator<S1> uo) { return null; }
    <S2> WrappingUnaryOperator<S2> wrap2(UnaryOperator<S2> uo) { return null; }
    <S3> WrappingUnaryOperator<S3> wrap3(UnaryOperator<S3> uo) { return null; }

    <P> List<List<P>> perm(List<P> l) { return null; }

    List<List<WrappingUnaryOperator<IntStream>>> intPermutationOfFunctions =
                perm(Arrays.asList(
                        wrap1(s -> s.sorted()),
                        wrap2(s -> s.distinct()),
                        wrap3(s -> s.limit(5))
                ));
}
