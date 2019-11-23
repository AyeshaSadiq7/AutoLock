/**
 * Copyright (c) 2006, 2007, 2008 Marwan Abi-Antoun, Jonathan Aldrich, Nels E. Beckman,
 * Kevin Bierhoff, David Dickey, Ciera Jaspan, Thomas LaToza, Gabriel Zenarosa, and others.
 *
 * This file is part of Crystal.
 *
 * Crystal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Crystal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Crystal.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.cmu.cs.crystal.tac.eclipse;

import java.util.List;

import org.eclipse.jdt.core.dom.PrefixExpression;

import edu.cmu.cs.crystal.ILabel;
import edu.cmu.cs.crystal.flow.IResult;
import edu.cmu.cs.crystal.flow.LatticeElement;
import edu.cmu.cs.crystal.tac.ITACBranchSensitiveTransferFunction;
import edu.cmu.cs.crystal.tac.ITACTransferFunction;
import edu.cmu.cs.crystal.tac.UnaryOperation;
import edu.cmu.cs.crystal.tac.UnaryOperator;
import edu.cmu.cs.crystal.tac.Variable;

/**
 * x = unop y; this class represents unary operations. 
 * Note that some seemingly unary operations such as x += y are  
 * desugared into binary operations.  
 * Pre- and post-increments and -decrements (++, --) are 
 * desugared as well.
 * 
 * @author Kevin Bierhoff
 *
 */
class UnaryOperationImpl extends AbstractAssignmentInstruction<PrefixExpression> 
implements UnaryOperation {
	
	private UnaryOperator operator;
	Object obj;
	
	/**
	 * @param node
	 * @param operator the unary operator.
	 * @param tac
	 * @see AbstractAssignmentInstruction#AbstractAssignmentInstruction(org.eclipse.jdt.core.dom.ASTNode, IEclipseVariableQuery)
	 */
	public UnaryOperationImpl(PrefixExpression node, UnaryOperator operator, IEclipseVariableQuery tac) {
		super(node, tac);
		if(operator == null) 
			throw new IllegalArgumentException("Unary operator not provided for node: " + node);
		this.operator = operator;
	}
	
	public Variable getOperand() {
		return variable(this.node.getOperand());
	}

	public UnaryOperator getOperator() {
		return operator;
	}
	
	@Override
	public <LE extends LatticeElement<LE>> LE transfer(ITACTransferFunction<LE> tf, LE value) {
		obj= new Object();
		return tf.transferOver19(this, value);
	}
	
	@Override
	public <LE extends LatticeElement<LE>> IResult<LE> transfer(ITACBranchSensitiveTransferFunction<LE> tf, List<ILabel> labels, LE value) {
		obj= new Object();
		return tf.transfer(this, labels, value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getTarget() + " = " + getOperator() + getOperand();
	}

}
