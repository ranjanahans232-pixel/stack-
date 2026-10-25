# StyleStock ER Diagram

Paste the Mermaid code below into https://mermaid.live to render/export the diagram as PNG or SVG.

```mermaid
erDiagram
    APP_USER {
        bigint user_id PK
        string full_name
        string email UK
        string password_hash
        string role
        boolean active
    }
    BRAND {
        bigint brand_id PK
        string brand_name
        string description
        boolean active
    }
    CATEGORY {
        bigint category_id PK
        string category_name
        string description
    }
    SUPPLIER {
        bigint supplier_id PK
        string supplier_name
        string email
        string phone
    }
    PRODUCT {
        bigint product_id PK
        string product_name
        string sku UK
        string size
        string colour
        decimal unit_price
        bigint brand_id FK
        bigint category_id FK
        bigint supplier_id FK
    }
    DISTRIBUTION_CENTRE {
        bigint centre_id PK
        string centre_name
        string address
        string city
    }
    INVENTORY {
        bigint inventory_id PK
        bigint product_id FK
        bigint centre_id FK
        int quantity
        int reorder_level
    }
    STOCK_TRANSFER {
        bigint transfer_id PK
        bigint product_id FK
        bigint source_centre_id FK
        bigint destination_centre_id FK
        int quantity
        date transfer_date
        string status
    }
    BRAND ||--o{ PRODUCT : brands
    CATEGORY ||--o{ PRODUCT : categorizes
    SUPPLIER ||--o{ PRODUCT : supplies
    PRODUCT ||--o{ INVENTORY : has
    DISTRIBUTION_CENTRE ||--o{ INVENTORY : stores
    PRODUCT ||--o{ STOCK_TRANSFER : transferred
    DISTRIBUTION_CENTRE ||--o{ STOCK_TRANSFER : source
    DISTRIBUTION_CENTRE ||--o{ STOCK_TRANSFER : destination
```

Note: AppUser is included as a planned domain entity in the ER model. This prototype uses in-memory Spring Security accounts for authentication.
