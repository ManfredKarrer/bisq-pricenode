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

package bisq.price.spot.providers;

import bisq.price.spot.ExchangeRateData;
import bisq.price.spot.ExchangeRateService;

import java.io.IOException;

import java.util.Map;

public class BitcoinAverageLocal extends BtcAverageProvider {

    @Override
    public Map<String, ExchangeRateData> request() throws IOException {
        return getMap(
                httpClient.requestWithGETNoProxy("indices/local/ticker/all?crypto=BTC", "X-signature", getHeader()),
                ExchangeRateService.BTCAVERAGE_LOCAL_PROVIDER);
    }
}
