import React, { useState, useEffect } from 'react';
import Chart from 'chart.js/auto'
import styled from 'styled-components';
import {CategoryScale} from 'chart.js';
import { Table } from './Table';
import { getAllUsers } from '.././services/AssocService'

export function DataDisplay() {

  const [data , setData] = useState([]);

 function getAllUser() {
    getAllUsers()
      .then(res => {
        const { data } = res;
        data.sort(( a, b) => b.association_score.overall - a.association_score.overall);
        setData(data.slice(0,4));
      });
  }

  useEffect(() => {
    getAllUser();
  }, []);


  Chart.register(CategoryScale);
 

const Styles = styled.div`
        padding: 1rem;
        .tableHead {
   
        }
        table {
          border-spacing: ;
          border: 1px solid black;
          th {
            font-size: 0.875rem;
            font-family: sans-serif;
            font-weight: 1500;
            line-height: 1.57;
            color: gray;
          }

          tr {
            border: 1px solid black;
            }
          }

          td {
            margin: 0;
            padding: 0.5rem;
            font-size: 0.875rem;
            font-family: "Inter", sans-serif;
            font-weight: 400;
            line-height: 1.43;
          }
        }
      `;

  const columns = React.useMemo(
    () => [
      { 
        Header: () => null,
        id: 'expander',
        Cell: ({ row }) => (
          <span {...row.getToggleRowExpandedProps()}>
            {row.isExpanded ? '-' : '+'}
          </span>
        ),
        SubCell: () => null
      },
      {
        Header: 'Approved Symbol',
            accessor: (d) => d.target.gene_info.symbol,
            Cell: e =><a href={'https://platform.opentargets.org/target/'+e.row.original.target.id} target="_blank"> {e.value} </a>
      },
      {
        Header: 'Gene Name',
        accessor: (d) => d.target.gene_info.name
      },
      {
        Header: 'Association score',
        accessor: (d) => d.association_score.overall
      }
    ],
    []
  );


  return (
    <div>
    <Styles>
    <h3 className ="tableHead">Genes associated with lung carcinoma</h3>
      <Table
        columns={columns}
        data={data}
      />
    </Styles>
    </div>
  );

}





