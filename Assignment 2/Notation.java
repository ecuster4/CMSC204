/**
 * Main driver class notation
 * @author Edwin Custer
 */
public class Notation 
{
	/**
	 * convert an infix to post fix expression
	 * @param infix what is being onverted
	 * @return postfix expression
	 * @throws InvalidNotationFormatException thrown expression
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		char[] array = infix.toCharArray();
		MyStack<String> stackTemp = new MyStack<String>(100);
		MyQueue<String> queueTemp = new MyQueue<String>(100);
		try
		{
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] == ' ')
				{
					continue;
				}
				if(array[i] =='(')
				{
					stackTemp.push(String.valueOf(array[i]));
				}
				if(array[i]==')')
				{
					while(!stackTemp.isEmpty() && !stackTemp.top().equals("("))
					{
						queueTemp.enqueue(stackTemp.pop());
					}
					if(stackTemp.isEmpty()||!stackTemp.top().equals("("))
					{
						throw new InvalidNotationFormatException();
					}
					if(!stackTemp.isEmpty()&&stackTemp.top().equals("("))
					{
						stackTemp.pop();
					}
				}
				if(array[i] == '-')
				{
					if(!stackTemp.isEmpty())
					{
						while(stackTemp.top().equals("-") || stackTemp.top().equals("+") || stackTemp.top().equals("/") ||stackTemp.top().equals("*"))
						{
							queueTemp.enqueue(stackTemp.pop());
						}
					}
					stackTemp.push(String.valueOf(array[i]));
				}
				if(array[i] == '+')
				{
					if(!stackTemp.isEmpty())
					{
						while(stackTemp.top().equals("-") || stackTemp.top().equals("+") || stackTemp.top().equals("/") ||stackTemp.top().equals("*"))
						{
							queueTemp.enqueue(stackTemp.pop());
						}
					}
					stackTemp.push(String.valueOf(array[i]));
				}
				if(array[i] == '/')
				{
					if(!stackTemp.isEmpty())
					{
						while(stackTemp.top().equals("/") ||stackTemp.top().equals("*"))
						{
							queueTemp.enqueue(stackTemp.pop());
						}
					}
					stackTemp.push(String.valueOf(array[i]));
				}
				if(array[i] == '*')
				{
					if(!stackTemp.isEmpty())
					{
						while(stackTemp.top().equals("/") ||stackTemp.top().equals("*"))
						{
							queueTemp.enqueue(stackTemp.pop());
						}
					}
					stackTemp.push(String.valueOf(array[i]));
				}
				if(Character.isDigit(array[i]))
				{
					queueTemp.enqueue(String.valueOf(array[i]));
				}
			}
			while(!stackTemp.isEmpty() && !stackTemp.top().equals("("))
			{
				queueTemp.enqueue(stackTemp.pop());
			}
		}
		catch(StackOverflowException a)
		{
			a.printStackTrace();
		}
		catch(StackUnderflowException b)
		{
			b.printStackTrace();
		}
		catch(QueueOverflowException c)
		{
			c.printStackTrace();
		}
		return queueTemp.toString();
	}
	/**
	 * Performs calculation
	 * @param first string to be calculated
	 * @param last string to be calculated
	 * @param operator used in calculations
	 * @return result of calculations
	 */
	private static double calculation(String first, String last, char operator)
	{
		double result = 0;
		switch (operator)
		{
			case '+':
				result = Double.parseDouble(first) + Double.parseDouble(last);
				break;
			case '*':
				result = Double.parseDouble(first) * Double.parseDouble(last);
				break;
			case '-':
				result = Double.parseDouble(first) - Double.parseDouble(last);
				break;
			case '/':
				result = Double.parseDouble(first) / Double.parseDouble(last);
				break;
		}
		return result;
	}
	/**
	 * calcuates of infix expression
	 * @param infixExpr evaulated epxression 
	 * @return result of expression
	 * @throws InvalidNotationFormatException thrown expression
	 */
	public static double evaluateInFixExpression(String infixExpr) throws InvalidNotationFormatException
	{
		String expression = convertInfixToPostfix(infixExpr);
		return evaluatePostfixExpression(expression);
	}
	/**
	 * convert an postfix to in fix
	 * @param postfix expression converted
	 * @return infix cconversion
	 * @throws InvalidNotationFormatException thrown expression
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException 
	{
		String first, last;
		MyStack<String> stackTemp = new MyStack<String>(100);
		char[] array = postfix.toCharArray();
		try 
		{
			for (int i = 0; i < array.length; i++)
			{
				if(Character.isDigit(array[i]))
				{
					stackTemp.push(String.valueOf(array[i]));
				}
				if(array[i] == ' ')
				{
					continue;
				}
				if(array[i] == '-' || array[i] == '+' ||array[i] == '*' ||array[i] == '/')
				{
					if(stackTemp.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						last = stackTemp.pop();
						first = "(" + stackTemp.pop() + array[i] + last + ")";
						stackTemp.push(first);
					}
				}
			}
			if(stackTemp.size() > 1)
			{
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackUnderflowException a)
		{
			a.printStackTrace();
		}
		catch(StackOverflowException b)
		{
			b.printStackTrace();
		}
		return stackTemp.toString();
	}
	/**
	 * calculate postfix expression
	 * @param postfixExpr expression evaulated
	 * @return the converted expression
	 * @throws InvalidNotationFormatException thrown expression
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		String first, last;
		MyStack<String> stackTemp = new MyStack<String>(100);
		char[] array = postfixExpr.toCharArray();
		double ans = 0;
		try 
		{
			for (int i = 0; i < array.length; i++)
			{
				if(array[i] == ' ')
				{
					continue;
				}
				if(Character.isDigit(array[i]))
				{
					stackTemp.push(String.valueOf(array[i]));
				}
				else
				{
					if(stackTemp.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else 
					{
						last = stackTemp.pop();
						first = stackTemp.pop();
						ans = calculation (first, last, array[i]);
						stackTemp.push(Double.toString(ans));
					}
				}
			}
			if(stackTemp.size() > 1)
			{
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackUnderflowException a)
		{
			a.printStackTrace();
		}
		catch(StackOverflowException b)
		{
			b.printStackTrace();
		}
		return ans;
	}
}