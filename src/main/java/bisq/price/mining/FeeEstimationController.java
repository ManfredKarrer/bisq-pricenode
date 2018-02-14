/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.price.mining;

import bisq.price.mining.providers.BitcoinFees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeeEstimationController {

    private final FeeEstimationService feeEstimationService;
    private final BitcoinFees feeEstimationProvider;

    public FeeEstimationController(FeeEstimationService feeEstimationService,
                                   BitcoinFees feeEstimationProvider) {
        this.feeEstimationService = feeEstimationService;
        this.feeEstimationProvider = feeEstimationProvider;
    }

    @GetMapping(path = "/getFees")
    public Map<String, Object> getFees() {
        return feeEstimationService.getFees();
    }

    @GetMapping(path = "/getParams")
    public String getParams() {
        return String.format("%s;%s;%s",
            feeEstimationProvider.getCapacity(),
            feeEstimationProvider.getMaxBlocks(),
            feeEstimationProvider.getTtl().toMillis());
    }
}
