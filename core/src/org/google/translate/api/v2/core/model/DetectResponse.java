package org.google.translate.api.v2.core.model;

import java.util.Arrays;

/**
 * Represents a Google Translate API detect response
 *
 * <pre>
 * {
 *  "data": {
 *      "detections": [
 *          [
 *              {
 *              "language": "en",
 *              "isReliable": false,
 *              "confidence": 0.65384614
 *              }
 *          ],
 *          [
 *              {
 *              "language": "zh-TW",
 *              "isReliable": false,
 *              "confidence": 0.39427105
 *              }
 *          ]
 *      ]
 *  }
 * }
 * </pre>
 *
 * @see DetectResponse
 * @see org.google.translate.api.v2.core.Translator#detect(String[])
 */
@SuppressWarnings("UnusedDeclaration")
public class DetectResponse extends AbstractResponse {

    private DetectResponseData data;

    public DetectResponseData getData() {
        return data;
    }

    public void setData(DetectResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DetectResponse{" +
                "data=" + data +
                '}';
    }

    public class DetectResponseData {
        private Detection[][] detections;

        public Detection[][] getDetections() {
            return detections;
        }

        public void setDetections(Detection[][] detections) {
            this.detections = detections;
        }

        @Override
        public String toString() {
            return "DetectResponseData{" +
                    "detections=" + (detections == null ? null : Arrays.deepToString(detections)) +
                    '}';
        }
    }
}
