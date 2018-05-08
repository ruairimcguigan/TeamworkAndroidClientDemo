package demo.teamwork.aquidigital.com.common.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Category{

	@SerializedName("id")
	public abstract String id();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("color")
	public abstract String color();

	public static TypeAdapter<Category> typeAdapter(Gson gson) {
		return new AutoValue_Category.GsonTypeAdapter(gson);
	}
}