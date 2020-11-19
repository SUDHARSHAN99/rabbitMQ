/**
 * 
 */
package com.example.demo.repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.PiiDataMapping;
import com.google.common.base.Stopwatch;


/**
 * @author prasad
 *
 */
@Service
public class RepoHelper {

	private final static Logger LOG = LoggerFactory.getLogger(RepoHelper.class);

	@Autowired
	private PiiDataMappingRepo piiDataMapRepository;

	public PiiDataMapping getMappingInfo(String contactID, String type, String resourceID, String dataSource) {
		PiiDataMapping piiDataMapping = null;
		if (!StringUtils.isEmpty(resourceID)) {
			Stopwatch timer = Stopwatch.createStarted();
			List<PiiDataMapping> mappings = piiDataMapRepository.findByResourceId(resourceID);
			LOG.info("piiDataMapRepository.findByResourceId(resourceID)" + timer.stop().elapsed(TimeUnit.MILLISECONDS));
			piiDataMapping = mappings.get(0);
		} else if (contactID != null && type != null && dataSource != null) {
			Stopwatch timer = Stopwatch.createStarted();
			List<PiiDataMapping> mappings = piiDataMapRepository
					.findByContactIdAndSourceTypeAndDataSourceOrderByDatePulledDesc(contactID, type, dataSource);
			LOG.info("piiDataMapRepository.findByContactIdAndSourceTypeAndDataSourceOrderByDatePulledDesc)" + timer.stop().elapsed(TimeUnit.MILLISECONDS));
			if (!CollectionUtils.isEmpty(mappings))
				piiDataMapping = mappings.get(0);
		}
		LOG.info("Fetched Mapping Info " + piiDataMapping);
		return piiDataMapping;
	}

	public List<PiiDataMapping> findResourceIds(String contactId, String type) {
		List<PiiDataMapping> list = piiDataMapRepository.findByContactIdAndSourceTypeOrderByDatePulledDesc(contactId,
				type);
		LOG.info("Fetched resourceIDs Info " + list);
		return list;
	}

	public PiiDataMapping save(PiiDataMapping mapping) {
		return piiDataMapRepository.save(mapping);
	}
	
	
}
