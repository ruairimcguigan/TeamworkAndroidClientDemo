package demo.teamwork.aquidigital.com.common.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Company{

	@SerializedName("id")
	public abstract String id();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("is-owner")
	public abstract String isOwner();

	public static TypeAdapter<Company> typeAdapter(Gson gson) {
		return new AutoValue_Company.GsonTypeAdapter(gson);
	}
}