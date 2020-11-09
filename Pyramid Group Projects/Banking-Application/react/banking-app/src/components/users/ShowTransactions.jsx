import react, {Component} from 'react'
import TransactionCtrlr from "../../services/TransactionCtrlr";

class ShowTransactions extends Component{
    constructor(props){
        super(props)
        this.state={
            id: this.props.match.params.id,
            transactionHistory: []
        }
        this.showTransactions = this.showTransactions.bind(this)
    }

    componentDidMount(){
        this.showTransactions()

    }

    showTransactions(id){
        console.log('Showing transaction history')
        TransactionCtrlr.getAllTrans(this.state.id)
            .then(
                response => {
                    this.setState({transactionHistory: response.data})
                    console.log({transactionHistory: response.data})
                }
            )
    }

    render() {
        return(
            <div>
                <div className="jumbotron" >
                    <div className=" table table-bordered" >
                        <thead>
                        <tr style={{textAlign: "center"}}>
                            <th>Type</th>
                            <th>Date</th>
                            <th>Amount</th>
                            <th>UserID</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.transactionHistory.map(
                                transactionHistory =>
                                    <tr style={{textAlign: "center"}} key={transactionHistory.id}>
                                        <td>{transactionHistory.type}</td>
                                        <td>{transactionHistory.date}</td>
                                        <td>{transactionHistory.amount}</td>
                                        <td>{transactionHistory.id}</td>
                                        <br></br>
                                        <br></br>
                                        <br></br>
                                    </tr>
                            )
                        }
                        </tbody>
                    </div>
                    <br></br>
                </div>
            </div>

        )
    }

}

export default ShowTransactions