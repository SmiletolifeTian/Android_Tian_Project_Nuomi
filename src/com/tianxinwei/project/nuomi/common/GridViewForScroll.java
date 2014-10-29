package com.tianxinwei.project.nuomi.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * ScrollViewǶ��GridView��ʱ������������ؼ����Դ���������
 * ����������һ���ʱ��������⣬��GridView����ʾ��ȫ��
 * @author T400
 *
 */
public class GridViewForScroll extends GridView {
	
	public GridViewForScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GridViewForScroll(Context context) {
		super(context);
	}

	public GridViewForScroll(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	//���Զ���ؼ�ֻ����д��GridView��onMeasure������ʹ�䲻����ֹ�������ScrollViewǶ��ListViewҲ��ͬ���ĵ���
	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
