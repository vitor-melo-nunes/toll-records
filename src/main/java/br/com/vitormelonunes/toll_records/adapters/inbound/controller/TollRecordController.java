package br.com.vitormelonunes.toll_records.adapters.inbound.controller;

import br.com.vitormelonunes.toll_records.application.model.TollRecord;
import br.com.vitormelonunes.toll_records.application.ports.inbound.TollRecordPortInbound;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/toll-records")
public class TollRecordController {

    @Autowired
    private TollRecordPortInbound tollRecordPortInbound;

    @GetMapping("/{tollRecordId}")
    public ResponseEntity<TollRecodResponse> getTollRecordById(@PathVariable @NotNull Long tollRecordId) throws Exception {
        TollRecord tollRecordFound = tollRecordPortInbound.getTollRecordByTollRecordId(tollRecordId);
        TollRecodResponse tollRecodFoundResponse = new TollRecodResponse(tollRecordFound);

        return ResponseEntity.ok(tollRecodFoundResponse);
    }

    @PostMapping("/")
    public ResponseEntity<TollRecodResponse> registerTollRecord(@Valid @RequestBody TollRecordRequest tollRecordRequest,
                                                                UriComponentsBuilder uriBuilder) throws Exception {
        TollRecord tollRecordCreated = tollRecordPortInbound
                .createTollRecord(tollRecordRequest.mapToRequestModel());

        TollRecodResponse tollRecodResponse = new TollRecodResponse(tollRecordCreated);
        URI tollRecordCreatedUri = uriBuilder.path("/toll-customers/{tollRecordId}")
                .buildAndExpand(tollRecodResponse.getTollRecordId()).toUri();

        return ResponseEntity.created(tollRecordCreatedUri).body(tollRecodResponse);
    }
}
