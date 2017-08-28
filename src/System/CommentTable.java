package System;

import java.util.Vector;

public class CommentTable extends Table{
	String[] coluname={"评论人","评论内容","评论时间","赞成"};
	CommentTable(Vector vs, Users user, int modelSet, int col) {
		super(vs, user, modelSet, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	void add(Vector vs) {
		// TODO Auto-generated method stub
		 Vector<Comment> coms=( Vector<Comment>) vs;
		
		 Vector v;
			for(Comment com:coms)
			{   v= new Vector();
				v.add(com.getCommenter());
				v.add(com.getComment());
				v.add(com.getTime().toString());
				v.add(com.getSupport());
				this.getmodel().addRow(v);
				
			}
	}

	@Override
	void mouseClickAction(int columnIndex, int rowIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void mouseMoveAction(int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
