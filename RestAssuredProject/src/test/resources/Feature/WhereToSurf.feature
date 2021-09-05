Feature: Find where to surf

  @tag1
  Scenario Outline: Find where to surf in Sydney
    Given An user try to find where to surf in Sydney
    And I look up the the weather forecast with <postal_code>
    And I only like to surf on Monday and Friday in next 16 days
    When I like to surf in any of two beaches Out of top ten of Sydney
    Then I check to if see the temperature is between <lowestTemp> and <highestTemp>
    And I check wind speed to be between <lowestWindSpeed> and <highestWindSpeed>
    And I check to see if UV index is equal or less than <UVIndex>
    And I Pick best suitable spot out of top two spots based upon suitable weather forecast for the day

    Examples: 
      | postal_code | lowestTemp | highestTemp | lowestWindSpeed | highestWindSpeed | UVIndex |
      |        2026 |         12 |          30 |               3 |                9 |      12 |
      |        2096 |         12 |          30 |               3 |                9 |      12 |
      |        2024 |         12 |          30 |               3 |                9 |      12 |
      |        2107 |         12 |          30 |               3 |                9 |      12 |
      |        2035 |         12 |          30 |               3 |                9 |      12 |
      |        2095 |         12 |          30 |               3 |                9 |      12 |
      |        2031 |         12 |          30 |               3 |                9 |      12 |
      |        2108 |         12 |          30 |               3 |                9 |      12 |
      |        2035 |         12 |          30 |               3 |                9 |      12 |
      |        2030 |         12 |          30 |               3 |                9 |      12 |