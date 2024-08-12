package com.callor.go.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BisStation {
	private String station_num;//	레코드 구분
	private String busstop_id;//	정류소 id
	private String busstop_name;//	정류소 명(국문)
	private String name_e;//		정류소 명(영문)
	private String longitude;//		위도
	private String latitude;// 		경도
	private String ars_id;// 		다음정류장
	private String next_busstop;// 	ARS 번호

}
