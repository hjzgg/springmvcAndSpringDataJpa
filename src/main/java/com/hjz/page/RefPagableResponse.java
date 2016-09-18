package com.hjz.page;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.hjz.page.annotation.BackField;
import com.hjz.page.annotation.DisplayText;
import com.hjz.page.annotation.FieldWidth;
import com.hjz.page.annotation.Hidden;

/**
 * 表参照返回数据
 * 
 * 
 */
public class RefPagableResponse extends PagableResponse {

	private List<Header> header;// 返回数据的头信息

	/**
	 * 构造函数
	 * 
	 * @param clazz
	 *            数据内容实体类型
	 */
	public RefPagableResponse(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (!"this$0".equals(field.getName())) {
				String code = field.getName();
				Column column = field.getAnnotation(Column.class);
				if (column != null) {
					code = column.name();
				}

				String text = field.getName();
				DisplayText displayText = field.getAnnotation(DisplayText.class);
				if (displayText != null) {
					text = displayText.value();
				}

				int width = 50;
				FieldWidth fieldWidth = field.getAnnotation(FieldWidth.class);
				if (fieldWidth != null) {
					width = fieldWidth.value();
				}

				boolean isBackField = false;
				BackField backField = field.getAnnotation(BackField.class);
				if (backField != null) {
					isBackField = backField.value();
				}

				boolean isHidden = false;
				Hidden hidden = field.getAnnotation(Hidden.class);
				if (hidden != null) {
					isHidden = hidden.value();
				}

				Header head = new Header(code, text, width, isBackField, isHidden);
				this.addHeader(head);
			}
		}
	}

	public List<Header> getHeader() {
		return header;
	}

	public void addHeader(Header head) {
		if (header == null) {
			header = new ArrayList<Header>();
		}
		this.header.add(head);
	}

	class Header {
		private String code;// 编码，一般为实体的属性名
		private String name;// 表头文字
		private int width;// 列宽， 默认为50
		private boolean backfiled;// 返回到Input单元格显示的字段
		private boolean hidden;// 是否显示该列

		public Header(String code, String name, int width, boolean backfiled, boolean hidden) {
			this.code = code;
			this.name = name;
			this.width = width;
			this.backfiled = backfiled;
			this.hidden = hidden;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public boolean isBackfiled() {
			return backfiled;
		}

		public void setBackfiled(boolean backfiled) {
			this.backfiled = backfiled;
		}

		public boolean isHidden() {
			return hidden;
		}

		public void setHidden(boolean hidden) {
			this.hidden = hidden;
		}
	}

}
