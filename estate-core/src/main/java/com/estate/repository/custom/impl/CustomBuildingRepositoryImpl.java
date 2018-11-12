package com.estate.repository.custom.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.page.PageRequest;
import com.estate.repository.custom.CustomBuildingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomBuildingRepositoryImpl implements CustomBuildingRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BuildingEntity> findAll(BuildingBuilder buildingBuilder, PageRequest pageRequest) {
		StringBuilder sql = new StringBuilder("select * from building where 1=1");
		List<BuildingEntity> result = new ArrayList<>();
		if(buildingBuilder.getAreaFrom() != null && buildingBuilder.getAreaTo() != null){
			sql.append(" and buiddingarea between :areaFrom and :areaTo");
		}
		if (buildingBuilder.getCostFrom() != null && buildingBuilder.getCostTo() != null){
			sql.append(" and pay between :costFrom and :costTo");
		}
		if (buildingBuilder.getDistrict() != null){
			sql.append(" and district = :district");
		}
		if (buildingBuilder.getStreet() != null){
			sql.append(" and street = :street");
		}
		if (buildingBuilder.getDirection() != null){
			sql.append(" and direction = :direction");
		}
		if (buildingBuilder.getLevel() != null){
			sql.append(" and level = :level");
		}
		if (buildingBuilder.getNumberOfBasement() != null){
			sql.append(" and numberofbasement = :numberOfBasement");
		}
		if (buildingBuilder.getProvince() != null){
			sql.append(" and province = :province");
		}
		Query query = entityManager.createNativeQuery(sql.toString());
		if(buildingBuilder.getAreaFrom() != null && buildingBuilder.getAreaTo() != null){
			query.setParameter("areaFrom", buildingBuilder.getAreaFrom());
			query.setParameter("areaTo", buildingBuilder.getAreaTo());
		}
		if (buildingBuilder.getCostFrom() != null && buildingBuilder.getCostTo() != null){
			query.setParameter("costFrom", buildingBuilder.getCostFrom());
			query.setParameter("costTo", buildingBuilder.getCostTo());
		}
		if (buildingBuilder.getDistrict() != null){
			query.setParameter("district", buildingBuilder.getDistrict());
		}
		if (buildingBuilder.getStreet() != null){
			query.setParameter("street", buildingBuilder.getStreet());
		}
		if (buildingBuilder.getDirection() != null){
			query.setParameter("direction", buildingBuilder.getDirection());
		}
		if (buildingBuilder.getLevel() != null){
			query.setParameter("level", buildingBuilder.getLevel());
		}
		if (buildingBuilder.getNumberOfBasement() != null){
			query.setParameter("numberOfBasement", buildingBuilder.getNumberOfBasement());
		}
		if (buildingBuilder.getProvince() != null){
			sql.append(" and province = :province");
			query.setParameter("province", buildingBuilder.getProvince());
		}

		if (pageRequest.getOffset() != null){
			query.setFirstResult(pageRequest.getOffset());
		}
		if (pageRequest.getPageSize() != null){
			query.setMaxResults(pageRequest.getPageSize());
		}

		result = query.getResultList();

		return  result;
	}

	@Override
	public Long getTotalItems(BuildingBuilder buildingBuilder) {
		StringBuilder sql = new StringBuilder("select * from building where 1=1");
		List<BuildingEntity> result = new ArrayList<>();
		if(buildingBuilder.getAreaFrom() != null && buildingBuilder.getAreaTo() != null){
			sql.append(" and buiddingarea between :areaFrom and :areaTo");
		}
		if (buildingBuilder.getCostFrom() != null && buildingBuilder.getCostTo() != null){
			sql.append(" and pay between :costFrom and :costTo");
		}
		if (buildingBuilder.getDistrict() != null){
			sql.append(" and district = :district");
		}
		if (buildingBuilder.getStreet() != null){
			sql.append(" and street = :street");
		}
		if (buildingBuilder.getDirection() != null){
			sql.append(" and direction = :direction");
		}
		if (buildingBuilder.getLevel() != null){
			sql.append(" and level = :level");
		}
		if (buildingBuilder.getNumberOfBasement() != null){
			sql.append(" and numberofbasement = :numberOfBasement");
		}
		if (buildingBuilder.getProvince() != null){
			sql.append(" and province = :province");
		}
		Query query = entityManager.createNativeQuery(sql.toString());
		if(buildingBuilder.getAreaFrom() != null && buildingBuilder.getAreaTo() != null){
			query.setParameter("areaFrom", buildingBuilder.getAreaFrom());
			query.setParameter("areaTo", buildingBuilder.getAreaTo());
		}
		if (buildingBuilder.getCostFrom() != null && buildingBuilder.getCostTo() != null){
			query.setParameter("costFrom", buildingBuilder.getCostFrom());
			query.setParameter("costTo", buildingBuilder.getCostTo());
		}
		if (buildingBuilder.getDistrict() != null){
			query.setParameter("district", buildingBuilder.getDistrict());
		}
		if (buildingBuilder.getStreet() != null){
			query.setParameter("street", buildingBuilder.getStreet());
		}
		if (buildingBuilder.getDirection() != null){
			query.setParameter("direction", buildingBuilder.getDirection());
		}
		if (buildingBuilder.getLevel() != null){
			query.setParameter("level", buildingBuilder.getLevel());
		}
		if (buildingBuilder.getNumberOfBasement() != null){
			query.setParameter("numberOfBasement", buildingBuilder.getNumberOfBasement());
		}
		if (buildingBuilder.getProvince() != null){
			sql.append(" and province = :province");
			query.setParameter("province", buildingBuilder.getProvince());
		}
		int size = query.getResultList().size();
		Long result1 = new Long(size);
		return   result1;
	}



}
