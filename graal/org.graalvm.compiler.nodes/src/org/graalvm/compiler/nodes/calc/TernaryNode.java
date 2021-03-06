/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.nodes.calc;

import org.graalvm.compiler.core.common.type.*;
import org.graalvm.compiler.graph.*;
import org.graalvm.compiler.graph.spi.*;
import org.graalvm.compiler.nodeinfo.*;
import org.graalvm.compiler.nodes.*;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * The {@code TernaryNode} class is the base of arithmetic and logic operations with three inputs.
 */
@NodeInfo
public abstract class TernaryNode extends FloatingNode implements Canonicalizable.Ternary<ValueNode> {

    public static final NodeClass<TernaryNode> TYPE = NodeClass.create(TernaryNode.class);
    @Input protected ValueNode x;
    @Input protected ValueNode y;
    @Input protected ValueNode z;

    public ValueNode getX() {
        return x;
    }

    public ValueNode getY() {
        return y;
    }

    public ValueNode getZ() {
        return z;
    }

    public void setX(ValueNode x) {
        updateUsages(this.x, x);
        this.x = x;
    }

    public void setY(ValueNode y) {
        updateUsages(this.y, y);
        this.y = y;
    }

    public void setZ(ValueNode z) {
        updateUsages(this.z, z);
        this.z = z;
    }

    /**
     * Creates a new TernaryNode instance.
     *
     * @param stamp the result type of this instruction
     * @param x the first input instruction
     * @param y the second input instruction
     * @param z the third input instruction
     */
    protected TernaryNode(NodeClass<? extends TernaryNode> c, Stamp stamp, ValueNode x, ValueNode y, ValueNode z) {
        super(c, stamp);
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
