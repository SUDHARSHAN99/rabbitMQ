/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.PiiDataMapping;

/**
 * @author prasad
 *
 */
public interface PiiDataMappingRepo extends JpaRepository<PiiDataMapping, Long> {

	List<PiiDataMapping> findByContactIdAndSourceTypeAndResourceId(String contactId, String source, String resourceID);

	List<PiiDataMapping> findByContactIdAndSourceTypeAndDataSourceOrderByDatePulledDesc(String contactId,
			String resourceID, String dataSource);

	List<PiiDataMapping> findByResourceId(String resourceID);

	List<PiiDataMapping> findByContactIdAndSourceTypeOrderByDatePulledDesc(
			String contactId, String type);

}
