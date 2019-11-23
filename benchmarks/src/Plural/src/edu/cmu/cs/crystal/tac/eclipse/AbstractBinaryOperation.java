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

import org.eclipse.jdt.core.dom.Expression;

import edu.cmu.cs.crystal.ILabel;
import edu.cmu.cs.crystal.flow.IResult;
import edu.cmu.cs.crystal.flow.LatticeElement;
import edu.cmu.cs.crystal.tac.BinaryOperation;
import edu.cmu.cs.crystal.tac.BinaryOperator;
import edu.cmu.cs.crystal.tac.ITACBranchSensitiveTransferFunction;
import edu.cmu.cs.crystal.tac.ITACTransferFunction;
import edu.cmu.cs.crystal.tac.Variable;

/**
 * x = y binop z, representing <i>all</i> binary operations.
 * Example:<br>
 * <code>a = f + g;</code><br>
 * 
 * To find out which type of binary operation this is, you have to
 * call getOperator() and compare it with the {@link BinaryOperator} 
 * enumerated type.<br>
 * 
 * 
 * @author Kevin Bierhoff
 *
 */
abstract class AbstractBinaryOperation<E extends Expression> extends AbstractAssignmentInstruction<E>  implements BinaryOperation {
	
	private BinaryOperator operator;
	Object obj;
	
	public AbstractBinaryOperation(E node, BinaryOperator operator, IEclipseVariableQuery tac) {
		super(node, tac);
		if(operator == null) 
			throw new IllegalArgumentException("Binary operator not provided for node: " + node);
		this.operator = operator;
	}

	public AbstractBinaryOperation(E node, BinaryOperator operator, boolean fresh, IEclipseVariableQuery tac) {
		super(node, fresh, tac);
		if(operator == null) 
			throw new IllegalArgumentException("Binary operator not provided for node: " + node);
		this.operator = operator;
	}

	public abstract Variable getOperand1();
	
	public BinaryOperator getOperator() {
		return operator;
	}

	public abstract Variable getOperand2();
	
	@Override
	public <LE extends LatticeElement<LE>> LE transfer(ITACTransferFunction<LE> tf, LE value) {
		obj = new Object();
		return tf.transferOver2(this, value);
	}

	@Override
	public <LE extends LatticeElement<LE>> IResult<LE> transfer(ITACBranchSensitiveTransferFunction<LE> tf, List<ILabel> labels, LE value) {
		obj = new Object();
		return tf.transferOver4(this, labels, value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getTarget() + " = " + getOperand1() + " " + getOperator() + " " + getOperand2();
	}

}
